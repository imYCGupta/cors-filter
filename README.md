# cors-filter
It explains how to handle Cross Origin Resource Sharing (CORS) issue while working with the applications where caller and receiver resides on two different application

Cross Origin Resource Sharing (CORS) as the name suggest, it acts an agreement for two application working on different ports/plaforms/enviornment etc. It occurs when Caller (Application trying to send request) wants to access any resource of Receiver (Application receiving the request). Before actual call goes out, Caller application send a OPTIONS request (OPTIONS is Request Method which will be sent no matter what actual Request method (GET, POST, DELETE, PUT) is) and check if it has access to get that resource. Receiver receives the request and see if that Origin from where the request is coming is identified or not and send the response back.

To handle this on Receiver end, we can create a filter layer on receiver which will take care. For Java sample code, [click here](https://github.com/imYCGupta/cors-filter/tree/master/src/main/java/com/geekwise/cors/filter/CORSFilter.java).
