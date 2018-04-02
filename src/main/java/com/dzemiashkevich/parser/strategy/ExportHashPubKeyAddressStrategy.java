package com.dzemiashkevich.parser.strategy;

import com.dzemiashkevich.parser.entity.UTXO;

public class ExportHashPubKeyAddressStrategy extends AbstractStrategy<UTXO> {

    @Override
    public void execute(final UTXO utxo) {
        write(utxo.getHash() + " " + utxo.getPubKey() + " " + utxo.getAddress());
    }

}
