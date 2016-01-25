import com.fasterxml.jackson.databind.ObjectMapper;

public class GreetingConsumer implements Runnable {
    private ObjectMapper objectMapper;
    private KafkaStream<byte[], byte[]> kafkaStream;
    private int threadNumber;
 
    public VideoConsumer(KafkaStream<byte[], byte[]> kafkaStream, int threadNumber) {
        this.threadNumber = threadNumber;
        this.kafkaStream = kafkaStream;
        this.objectMapper = new ObjectMapper();
    }
    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = kafkaStream.iterator();
        
        while (it.hasNext()) {
            byte[] messageData = it.next().message();
            try {
                Video videoFromMessage = objectMapper.readValue(messageData, Video.class);
                System.out.println("Thread:" + threadNumber + ".Consuming video: " + videoFromMessage);
            } catch (JsonParseException | JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
        System.out.println("Shutting down Thread: " + kafkaStream);
    }
}