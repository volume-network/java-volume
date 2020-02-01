package vlm.grpc.handlers;

import vlm.Account;
import vlm.grpc.GrpcApiHandler;
import vlm.grpc.proto.ApiException;
import vlm.grpc.proto.ProtoBuilder;
import vlm.grpc.proto.VlmApi;
import vlm.services.AccountService;

public class GetAccountHandler implements GrpcApiHandler<VlmApi.GetAccountRequest, VlmApi.Account> {
    private final AccountService accountService;

    public GetAccountHandler(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public VlmApi.Account handleRequest(VlmApi.GetAccountRequest request) throws Exception {
        Account account;
        try {
            account = accountService.getAccount(request.getId());
            if (account == null) throw new NullPointerException();
        } catch (RuntimeException e) {
            throw new ApiException("Could not find account");
        }
        return ProtoBuilder.buildAccount(account, accountService);
    }
}
