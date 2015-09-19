spring-boot-async
===================

# Features
- Use of async on a spring boot app

##Learnins
Examples of async simulating slow service.
- Use of synchronous mode benefits from not dealing with the flow of the different threads. No need to check for completed tasks. A linear mindset, everyone can understand
- Use of async forces developer to program where is every thread and deal with terminated/non terminated tasks. Maybe it would be useful to write a framework on top of that for finished/non finished tasks.

- If not critically important, would use the synchronous service. Note the example is just a quick programming test, normally async is much more complex.
- Also, need to consider if we need the results or not (could be a standalone process writing to database and indexing). If we do not needed i would definitely go for async. It is so good to have multithreaded program witout even understanding concurrency.
- If need the result and it is importantn the efficiency, use of Async on the service and wrap the result with an AsyncResult. The interface will expose a Future of the object retrieved in the time.


