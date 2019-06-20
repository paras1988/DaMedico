package com.flink.examples;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class WordCountStream {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();

        DataStreamSource<String> source =  env.readTextFile("D:\\workspace2\\DaMedico\\flink\\src\\main\\resources\\wc.txt");

        DataStream<Tuple2<String, Integer>> dataStream  = source.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                out.collect(new Tuple2<>(value,1));
            }
        });

        DataStream<Tuple2<String, Integer>> counts = dataStream.keyBy(0).sum(1);

        counts.print();

        env.execute("Stream workd count");
    }
}
