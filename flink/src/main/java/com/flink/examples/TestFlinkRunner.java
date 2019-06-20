package com.flink.examples;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

import java.util.Date;
import java.util.Properties;

public class TestFlinkRunner {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");
        properties.setProperty("security.protocol","PLAINTEXT");
        properties.setProperty("sasl.mechanism","PLAINTEXT");
        properties.setProperty("group.id","test_group");
        properties.put("num.partitions", 3);

        DataStream<String> payments = env.addSource(new StringSource());

        payments.keyBy(payments.getId());
        payments.print();
        payments.addSink(new FlinkKafkaProducer011<>("TOPIC-1",new SimpleStringSchema(),properties));

        env.execute("FLINK-JOB-TOPIC-1");
    }

    public static class StringSource implements SourceFunction<String> {

        @Override
        public void run(SourceContext<String> ctx) throws Exception {


            for (int i = 0; i < 9; i++){
                ctx.collectWithTimestamp("data_"+i, new Date().getTime());
                Thread.sleep(200);
            }
        }

        @Override
        public void cancel() {

        }
    }

}

