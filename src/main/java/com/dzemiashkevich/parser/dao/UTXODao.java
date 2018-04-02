package com.dzemiashkevich.parser.dao;

import com.dzemiashkevich.parser.entity.BalancePair;
import com.dzemiashkevich.parser.entity.DatePair;
import com.dzemiashkevich.parser.entity.UTXO;

import java.util.List;

public class UTXODao {

    private final static String SELECT_UTXO = "";
    private final static String SELECT_UTXO_BY_ADDRESS = "";

    public List<UTXO> read(final DatePair datePair, final BalancePair balancePair, final String addressStartWith) {
        //TODO
        return null;
    }

    public List<UTXO> read(final DatePair datePair, final BalancePair balancePair) {
        return this.read(datePair, balancePair, null);
    }



}
