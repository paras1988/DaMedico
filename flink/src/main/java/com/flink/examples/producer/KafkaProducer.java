package com.flink.examples.producer;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

import java.util.Properties;

public class KafkaProducer {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        DataStream<String> payments = env.addSource(new StringSource());

        Properties p = new Properties();
        p.setProperty("bootstrap.servers", "127.0.0.1:9092");


        payments.print();
        payments.addSink(new FlinkKafkaProducer011<>("test",
                new SimpleStringSchema(),p));

        env.execute("KAFKA Producer");
    }

    static class StringSource implements SourceFunction<String>
    {
        private static final long serialVersionUID = 1L;


        @Override
        public void run(SourceContext<String> ctx) throws Exception {
            for(int i=0;i<5;i++){
                String str = "Element "+i+" Element 2"+i;
              //  System.out.println(str);
                ctx.collect(str);
                Thread.sleep(500);
            }
        }

        @Override
        public void cancel() {

        }
    }
}




