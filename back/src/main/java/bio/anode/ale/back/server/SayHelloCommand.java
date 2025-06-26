package bio.anode.ale.back.server;

import java.time.Year;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import sila_java.library.core.sila.errors.SiLAErrors;
import sila_java.library.core.sila.types.SiLAInteger;
import sila_java.library.core.sila.types.SiLAString;
import sila2.org.silastandard.examples.greetingprovider.v1.GreetingProviderGrpc;
import sila2.org.silastandard.examples.greetingprovider.v1.GreetingProviderOuterClass;


@Slf4j
public class SayHelloCommand extends GreetingProviderGrpc.GreetingProviderImplBase {
    private static final String FULLY_QUALIFIED_FEATURE_IDENTIFIER = "org.silastandard/examples/TestFeature/v1";

    /**
     * Implementation of the SayHello Command, the mapping can be referred to from Part B
     */
    @Override
    public void sayHello(
            GreetingProviderOuterClass.SayHello_Parameters req,
            StreamObserver<GreetingProviderOuterClass.SayHello_Responses> responseObserver
    ) {
            /*
             Different parameters can be checked, it is mandatory to throw Validation Errors in case of
             missing parameters, which will be done automatically in the future.
              */
        if (!req.hasName()) {
            responseObserver.onError(SiLAErrors.generateValidationError(
                    FULLY_QUALIFIED_FEATURE_IDENTIFIER + "/Command/SayHello/Parameter/" + "Name",
                    "Name parameter was not set. Specify a name with at least one character"
            ));
            return;
        }

        // Custom ValidationError example
        String name = req.getName().getValue();
        if ("error".equalsIgnoreCase(name)) {
            responseObserver.onError(
                    SiLAErrors.generateValidationError(
                            FULLY_QUALIFIED_FEATURE_IDENTIFIER + "/Command/SayHello/Parameter/" + "Name",
                            "Name was called error therefore throw an error :). " +
                                    "Specify a name that is not \"error\""
                    )
            );
            return;
        }

        final String msg = "Hello " + name;
        GreetingProviderOuterClass.SayHello_Responses result =
                GreetingProviderOuterClass.SayHello_Responses
                        .newBuilder()
                        .setGreeting(SiLAString.from(msg))
                        .build();

        responseObserver.onNext(result);
        responseObserver.onCompleted();

    }

    /**
     * Implementation of the unobservable property Start Year
     *
     * It works just like a command but doesn't have any parameters and shouldn't change any
     * state of the server or some underlying instrument or database.
     */
    @Override
    public void getStartYear(
            GreetingProviderOuterClass.Get_StartYear_Parameters request,
            StreamObserver<GreetingProviderOuterClass.Get_StartYear_Responses> responseObserver
    ) {
        responseObserver.onNext(
                GreetingProviderOuterClass.Get_StartYear_Responses
                        .newBuilder()
                        .setStartYear(SiLAInteger.from(Year.now().getValue()))
                        .build()
        );
        responseObserver.onCompleted();
    }

}

