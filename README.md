# cors-filter
It explains how to handle Cross Origin Resource Sharing (CORS) issue while working with the applications where caller and receiver resides on two different application

Cross Origin Resource Sharing (CORS) as the name suggest, it acts an agreement for two application working on different ports/plaforms/enviornment etc. It occurs when Caller (Application trying to send request) wants to access any resource of Receiver (Application receiving the request). Before actual call goes out, Caller application send a OPTIONS request (OPTIONS is Request Method which will be sent no matter what actual Request method (GET, POST, DELETE, PUT) is) and check if it has access to get that resource. Receiver receives the request and see if that Origin from where the request is coming is identified or not and send the response back.

To handle this on Receiver end, we can create a filter layer on receiver which will take care. For Java sample code, [click here](https://github.com/imYCGupta/cors-filter/tree/master/src/main/java/com/geekwise/cors/filter/CORSFilter.java).

If any call is going from Angular JS application or Angular application or Javascript application hosted on different port/platform than backend then this issue will occur. After adding a filter layer as discussed above in application, get this filter attached in web context so that any request coming to the server get passed through that filter.

To attach filter in web context, in JAVA it can be done like follows - 

<ul>
  <li>Open web.xml</li>
  <li>Create a filter Tag and define name of that filter. For filter-class, give the name of Class explained above with package name</li>
  <li>Create filter-mapping tag and use same filter name defined above. And define url-pattern for which you want to trigger this filter. If you want if for all request, then use /* in url-pattern.</li>
</ul>

Eg. 

<pre>
  &lt;filter&gt;
		&lt;filter-name>corsFilter&lt;/filter-name&gt;
		&lt;filter-class>com.geekwise.cors.filter.CORSFilter&lt;/filter-class&gt;
	&lt;/filter&gt;

	&lt;filter-mapping&gt;
		&lt;filter-name&gt;corsFilter&lt;/filter-name&gt;
		&lt;url-pattern&gt;/*&lt;/url-pattern&gt;
	&lt;/filter-mapping&gt;
  </pre>
