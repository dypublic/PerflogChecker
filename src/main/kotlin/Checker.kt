package checker
//import com.beust.klaxon
import org.apache.kafka.clients.consumer.Consumer
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration
import java.util.*

private fun createConsumer(brokers: String): Consumer<String, String> {
    val props = Properties()
    props["bootstrap.servers"] = brokers
    props["group.id"] = "person-processor"
    props["key.deserializer"] = StringDeserializer::class.java
    props["value.deserializer"] = StringDeserializer::class.java
    return KafkaConsumer<String, String>(props)
}

fun main() {
    val consumer = createConsumer("bdprodkafka01.dbhotelcloud.com:9092,bdprodkafka02.dbhotelcloud.com:9092,bdprodkafka03.dbhotelcloud.com:9092")
    consumer.subscribe(listOf("perf_hilton-adapter_raw"))
    while (true) {
        val records = consumer.poll(Duration.ofSeconds(1))
        records.iterator().forEach {
            println(it.value())
        }
    }

}