package service;

import model.AuditEntity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Audit {
    private static Audit instance;
    private static FileWriter writer;
    private static String path;

    private Audit(){
        try{
            path = "audit.csv";
            writer  = new FileWriter(path);
        }catch (Exception e){
            System.out.println("Couldn`t open file for audit");
        }
    }

    public static Audit getInstance() {
        if (instance == null) {
            instance = new Audit();
        }
        return instance;
    }

    public static void log(AuditEntity audit){
        try {
            writer.append(audit.getSchema());
            writer.append(", ");
            writer.append(audit.getTable());
            writer.append(", ");
            writer.append(audit.getSqlStatement());
            writer.append("\n");

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void log_multiple(ArrayList<AuditEntity> list) {
        try {
            for (var item: list) {
                writer.append(item.getSchema());
                writer.append(", ");
                writer.append(item.getTable());
                writer.append(", ");
                writer.append(item.getSqlStatement());
                writer.append("\n");
            }

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
