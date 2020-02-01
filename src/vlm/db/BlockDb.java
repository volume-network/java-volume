package vlm.db;

import org.jooq.DSLContext;
import vlm.Block;
import vlm.VolumeException;
import vlm.schema.tables.records.BlockRecord;

import java.sql.ResultSet;

public interface BlockDb {
    Block findBlock(long blockId);

    boolean hasBlock(long blockId);

    long findBlockIdAtHeight(int height);

    Block findBlockAtHeight(int height);

    Block findLastBlock();

    Block findLastBlock(int timestamp);

    Block loadBlock(DSLContext ctx, ResultSet rs) throws VolumeException.ValidationException;

    Block loadBlock(BlockRecord r) throws VolumeException.ValidationException;

    void saveBlock(DSLContext ctx, Block block);

    // relying on cascade triggers in the database to delete the transactions for all deleted blocks
    void deleteBlocksFrom(long blockId);

    void deleteAll(boolean force);
}
