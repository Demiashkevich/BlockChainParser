package com.dzemiashkevich.parser.strategy;

import com.dzemiashkevich.parser.entity.UTXO;

public class ExportHashPubKeyStrategy extends AbstractStrategy<UTXO> {

    @Override
    public void execute(final UTXO utxo) {
        write(utxo.getHash() + " " + utxo.getPubKey());
    }

}
