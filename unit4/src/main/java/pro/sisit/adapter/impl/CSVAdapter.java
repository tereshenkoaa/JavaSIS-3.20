package pro.sisit.adapter.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import org.apache.commons.io.FileUtils;
import pro.sisit.adapter.IOAdapter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;

// 1. TODO: написать реализацию адаптера

public class CSVAdapter<T> implements IOAdapter<T> {

    private Class<T> entityType;
    private String pathToFile;

    public CSVAdapter(Class<T> entityType, String pathToFile) {
        this.entityType = entityType;
        this.pathToFile = pathToFile;
    }

    @Override
    public Object read(int index) {

        //throw new RuntimeException("Метод read не реализован");
        Class clazz = null;
        try {
            clazz = Class.forName(entityType.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс "+entityType.getName());
            e.printStackTrace();
        }

        File file = new File(pathToFile);
        String line = null;
        try {
            line = (String) FileUtils.readLines(file,"UTF-8").get(index-1);
        } catch (IOException e) {
            System.out.println("Не найдена строка с в файле данных");
            e.printStackTrace();
            return null;
        }

        Object obj = null;
        try {
            obj = clazz.getConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Не найден конструктор с пустыми аргументами у класса "+entityType.getName());
            e.printStackTrace();
        }

        String[] str = line.split(";");
        Field[] fields = clazz.getDeclaredFields();

        int cnt = 0;
        for(Field field: fields) {
            field.setAccessible(true);
            try {
                field.set(obj, str[cnt]);
            } catch (IllegalAccessException e) {
                System.out.println("Ошибка присвоения значения "+str[cnt]+" полю "+field.getName());
                e.printStackTrace();
            }
            cnt++;
        }

        return obj;
    }

    @Override
    public int append(T entity) {
        //throw new RuntimeException("Метод append не реализован");

        File file = new File(pathToFile);
        StringBuffer strBuffer = new StringBuffer();
        String name;
        Field currentField;

        Field[] f = entityType.getDeclaredFields();
        for (int i = 0; i < f.length; i++) {

            currentField = f[i];

            if (Modifier.isPrivate(currentField.getModifiers())) {
                currentField.setAccessible(true);
            }

            try {
                name = (String) currentField.get(entity);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                name = "";
            }
            strBuffer.append(name);
            strBuffer.append(";");
        }

        strBuffer.append(System.lineSeparator());

        try {
            FileUtils.write(
                    file,
                    strBuffer,
                    "UTF-8",
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            writer.newLine();
//            writer.write(strBuffer.toString());
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        try {
            return FileUtils.readLines(file,"UTF-8").size();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }


    }

}
