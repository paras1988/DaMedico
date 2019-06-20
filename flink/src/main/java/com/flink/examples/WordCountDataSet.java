package com.flink.examples;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class WordCountDataSet {

    public static void main(String[] args) throws Exception {

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSource<String> source =  env.readTextFile("D:\\workspace2\\DaMedico\\flink\\src\\main\\resources\\wc.txt");

        DataSet<Tuple2<String, Integer>> dataSet  = source.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                out.collect(new Tuple2<>(value,1));
            }
        });

        DataSet<Tuple2<String, Integer>> counts = dataSet.groupBy(0).sum(1);

        counts.print();
        counts.writeAsCsv("D:\\workspace2\\DaMedico\\flink\\src\\main\\resources\\wc_out", "\n", " ");

        env.execute("Batch workd count");
    }
}
