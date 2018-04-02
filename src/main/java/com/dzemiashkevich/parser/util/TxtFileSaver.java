package com.dzemiashkevich.parser.util;

import com.dzemiashkevich.parser.entity.UTXO;
import com.dzemiashkevich.parser.strategy.Strategy;

import java.util.List;

public class TxtFileSaver implements FileSaver<UTXO> {
    @Override
    public void execute(final Strategy<UTXO> strategy, final List<UTXO> utxoTransactions) {
        utxoTransactions.forEach(strategy::execute);
    }
}
