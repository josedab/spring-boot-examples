spring-boot-producer
===================

# Features
- Produces messages to a kafka topic on a spring boot app

##Learnings
- Expose singleton objects on the config through Bean
   - Object mapper, producer config, props...
- Keep the partitioning as clean as possible
- Use of async producer
- Changes on serialization classes on the new 0.8.2.2 interface
