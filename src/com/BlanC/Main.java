package com.BlanC;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import com.microsoft.azure.documentdb.*;
import com.google.gson.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {
	// write your code here
        System.out.print("hi");
        Farmer ft = new Farmer("a","b","afs");
        System.out.println(ft.GetName() + ft.GetSurName() + ft.GetAddress());

       // Entry();
    }

 /*   public static void Entry() throws IOException {
           PrintWriter PW = new PrintWriter("Farmer.csv");
            PW.print("Name "); PW.println("RollNum");
            PW.print("Dhanush "); PW.println(123);
            PW.print("Guru "); PW.println(456);
            PW.print("QWERTY "); PW.println(567);

            PW.close();

        File fs = new File("Farmer.csv");
   CsvWriter cw = new CsvWriter(new FileWriter("Farmer.csv",true),',');

        //Writing Headers
        cw.write("Name");
        cw.write("ID");
        cw.endRecord();

        //writing Records


        cw.write("Dhanush");
        cw.write("123");
        cw.endRecord();

        cw.write("Guru");
        cw.write("456");
        cw.endRecord();

        cw.write("Dan");
        cw.write("789");
        cw.endRecord();

        cw.close();

        //Some problem in reading a file, showing FileNotFound exception

            try {
                CsvReader cr = new CsvReader("Farmers.csv");
                System.out.println(cr.get("Name"));
            }
            catch (FileNotFoundException fe)
            {
                fe.printStackTrace();

            }*/


    }


class DocdbTest
{
    public DocdbTest() throws IOException, DocumentClientException
    {
        //Docdbtest();
    }
    // to connect to databases
    private static final String END_POINT = "https://localhost:8081/";
    private static final String MASTER_KEY = "C2y6yDjf5/R+ob0N8A7Cgv30VRDJIWEHLM+4QDU5DE2nQ9nDuVTqobD4b8mGGyPMbIZnqyMsEcaGQy67XIw/Jw==";

    //id of data base and collection
    private static final String DATABASE_ID = "TestDB";
    private static final String COLLECTION_ID = "TestCollection";


    private static Gson gson = new Gson();

    public void Docdbtest() throws IOException,DocumentClientException
    {
       /* TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
            @Override
            public X509Certificate[] getAcceptedIssuers(){return new X509Certificate[0];}
            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType){}
            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            ;
        }
       /* ClientConfig config = new DefaultClientConnectiontConfig();
        config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES, new HTTPSProperties(
                new HostnameVerifier() {
                    @Override
                    public boolean verify( String s, SSLSession sslSession ) {
                        // whatever your matching policy states
                    }
                }
        ));
        Client client = Client.create(config);  */

        // Instantiate a DocumentClient w/ your DocumentDB Endpoint and AuthKey.
        //DocumentClient documentClient = new DocumentClient(END_POINT,
        // MASTER_KEY, ConnectionPolicy.GetDefault(),
        //ConsistencyLevel.Session);
        ConnectionPolicy c = ConnectionPolicy.GetDefault();
        c.setEnableEndpointDiscovery(false);
        DocumentClient documentClient = new DocumentClient(END_POINT,MASTER_KEY,c, ConsistencyLevel.Session);

        // Start from a clean state (delete database in case it already exists).
     /*   try {
            documentClient.deleteDatabase("dbs/" + DATABASE_ID, null);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } */

        // Define a new database using the id above.
        Database myDatabase = new Database();
        myDatabase.setId(DATABASE_ID);

        // Create a new database.
        myDatabase = documentClient.createDatabase(myDatabase, null).getResource();


        System.out.println("Created a new database:");
        System.out.println(myDatabase.toString());
        System.out.println("Press any key to continue..");
        System.in.read();

        // Define a new collection using the id above.
        DocumentCollection myCollection = new DocumentCollection();
        myCollection.setId(COLLECTION_ID);

        // Set the provisioned throughput for this collection to be 1000 RUs.
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.setOfferThroughput(1000);

        // Create a new collection.
        myCollection = documentClient.createCollection(
                "dbs/" + DATABASE_ID, myCollection, requestOptions)
                .getResource();

        System.out.println("Created a new collection:");
        System.out.println(myCollection.toString());
        System.out.println("Press any key to continue..");
        System.in.read();

        // Create an object, serialize it into JSON, and wrap it into a
        // document.
        Farmer ft = new Farmer("a","b","afs");
        String farmer = gson.toJson(ft);
        Document farmerdoc = new Document(farmer);


        // Create the 1st document.
        farmerdoc = documentClient.createDocument(
                "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, farmerdoc, null, false)
                .getResource();

        System.out.println("Created 1st document:");
        System.out.println(farmerdoc.toString());
        System.out.println("Press any key to continue..");
        System.in.read();

        // Create another object, serialize it into JSON, and wrap it into a
        // document.
        Farmer ft1 = new Farmer("ab","cd","efg");
        String farmer2 = gson.toJson(ft);
        Document farmerdoc2 = new Document(farmer2);

        // Create the 2nd document.
        farmerdoc2 = documentClient.createDocument(
                "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID, farmerdoc2, null, false)
                .getResource();

        System.out.println("Created 2nd document:");
        System.out.println(farmerdoc2.toString());
        System.out.println("Press any key to continue..");
        System.in.read();

       /* // Query documents
        List<Document> results = documentClient
                .queryDocuments(
                        "dbs/" + DATABASE_ID + "/colls/" + COLLECTION_ID,
                        "SELECT * FROM myCollection WHERE myCollection.email = 'allen [at] contoso.com'",
                        null).getQueryIterable().toList();

        System.out.println("Query document where e-mail address = 'allen [at] contoso.com':");
        System.out.println(results.toString());
        System.out.println("Press any key to continue..");
        System.in.read();

        // Replace Document Allen with Percy
        allenPojo = gson.fromJson(results.get(0).toString(), SomePojo.class);
        allenPojo.setName("Percy Bowman");
        allenPojo.setEmail("Percy Bowman [at] contoso.com");

        allenDocument = documentClient.replaceDocument(
                allenDocument.getSelfLink(),
                new Document(gson.toJson(allenPojo)), null)
                .getResource();

        System.out.println("Replaced Allen's document with Percy's contact information");
        System.out.println(allenDocument.toString());
        System.out.println("Press any key to continue..");
        System.in.read();

        // Delete Percy's Document
        documentClient.deleteDocument(allenDocument.getSelfLink(), null);

        System.out.println("Deleted Percy's document");
        System.out.println("Press any key to continue..");
        System.in.read();

        // Delete Database
        documentClient.deleteDatabase("dbs/" + DATABASE_ID, null);

        System.out.println("Deleted database");
        System.out.println("Press any key to continue..");
        System.in.read(); */

    }
}


