package vlm.grpc.handlers;

import vlm.grpc.GrpcApiHandler;
import vlm.grpc.proto.ProtoBuilder;
import vlm.grpc.proto.VlmApi;
import vlm.services.AccountService;

import java.util.Objects;

public class GetAccountsHandler implements GrpcApiHandler<VlmApi.GetAccountsRequest, VlmApi.Accounts> {

    private final AccountService accountService;

    public GetAccountsHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public VlmApi.Accounts handleRequest(VlmApi.GetAccountsRequest request) throws Exception {
        VlmApi.Accounts.Builder builder = VlmApi.Accounts.newBuilder();
        if (!Objects.equals(request.getName(), "")) {
            if (request.getIncludeAccounts()) {
                accountService.getAccountsWithName(request.getName()).forEachRemaining(account -> builder.addAccounts(ProtoBuilder.buildAccount(account, accountService)));
            } else {
                accountService.getAccountsWithName(request.getName()).forEachRemaining(account -> builder.addAccountIDs(account.getId()));
            }
        }
        if (request.getRewardRecipient() != 0) {
            if (request.getIncludeAccounts()) {
                accountService.getAccountsWithRewardRecipient(request.getRewardRecipient()).forEachRemaining(assignment -> builder.addAccounts(ProtoBuilder.buildAccount(accountService.getAccount(assignment.getAccountId()), accountService)));
            } else {
                accountService.getAccountsWithRewardRecipient(request.getRewardRecipient()).forEachRemaining(assignment -> builder.addAccountIDs(assignment.getAccountId()));
            }
        }
        return builder.build();
    }
}
