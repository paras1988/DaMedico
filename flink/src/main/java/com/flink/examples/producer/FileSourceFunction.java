package com.flink.examples.producer;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileSourceFunction implements SourceFunction<String> {

    private static final long serialVersionUID = 1L;

    @Override
    public void run(SourceContext<String> ctx) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("D:\\workspace2\\DaMedico\\flink\\src\\main\\resources\\avg.txt"));

        try {
            String line;
            while ((line = br.readLine()) != null){

               // System.out.println("Input "+line);
                ctx.collect(line);
                Thread.sleep(500);
            }

        }
        catch (Exception e){

            e.printStackTrace();
        }finally{
            br.close();
        }
    }

    @Override
    public void cancel() {

    }
}
