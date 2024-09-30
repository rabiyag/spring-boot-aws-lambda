package com.aws.lambda.controller;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lambda")
public class LambdaController {

    @PostMapping("/invoke")
    public String invokeLambda(@RequestBody String input) {
        AWSLambda lambdaClient = AWSLambdaClientBuilder.defaultClient();
        
        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName("MyLambdaFunction") 
                .withPayload(input);
        
        return new String(lambdaClient.invoke(invokeRequest).getPayload().array());
    }
}
