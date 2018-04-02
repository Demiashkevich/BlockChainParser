package com.dzemiashkevich.parser;

import com.dzemiashkevich.parser.dao.UTXODao;
import com.dzemiashkevich.parser.entity.BalancePair;
import com.dzemiashkevich.parser.entity.DatePair;
import com.dzemiashkevich.parser.entity.UTXO;
import com.dzemiashkevich.parser.strategy.*;
import com.dzemiashkevich.parser.util.FileScanner;
import com.dzemiashkevich.parser.util.TxtFileSaver;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Runner {

    private static final Scanner scanner = new Scanner(System.in);

    private static String startWith;
    private static String fromStr;
    private static String toStr;
    private static int fromBalance;
    private static int toBalance;

    public static void main(String[] args) throws ParseException {
        step1();
    }

    private static void step1() throws ParseException {
        System.out.println("1 - Update");
        System.out.println("2 - Export hash and public key");
        System.out.println("3 - Export address");
        System.out.println("4 - Export hash, public key and address");
        final String step1 = scanner.nextLine();

        switch (step1) {
            case "1": {
                final Optional<List<File>> files = FileScanner.getAbsolutePath("." + File.separator, "blk", ".dat");
                if (!files.isPresent()) {
                    break;
                }
                new UpdateStrategy().execute(files.get());
            } break;

            case "2": {
                step3(new ExportHashPubKeyStrategy());
            } break;

            case "3": {
                step2(new ExportAddressStrategy());
            } break;

            case "4": {
                step2(new ExportHashPubKeyAddressStrategy());
            } break;
        }
    }

    public static void step2(final Strategy<UTXO> strategy) throws ParseException {
        System.out.println("Parse by address START WITH: ");
        startWith = scanner.nextLine();
        step3(strategy);
    }

    private static void step3(final Strategy<UTXO> strategy) throws ParseException {
        System.out.println("Parse by date FROM (FORMAT DD-MM-YYYY): ");
        fromStr = scanner.nextLine();
        System.out.println("Parse by date TO (FORMAT DD-MM-YYYY): ");
        toStr = scanner.nextLine();
        System.out.println("Parse by balance FROM: ");
        fromBalance = scanner.nextInt();
        System.out.println("Parse by balance TO: ");
        toBalance = scanner.nextInt();

        final Date fromDate = new SimpleDateFormat("DD-MM-YYYY").parse(fromStr);
        final Date toDate = new SimpleDateFormat("DD-MM-YYYY").parse(toStr);
        final List<UTXO> result = new UTXODao().read(
                new DatePair(fromDate, toDate),
                new BalancePair(fromBalance, toBalance),
                startWith
        );

        new TxtFileSaver().execute(strategy, result);
    }

}
