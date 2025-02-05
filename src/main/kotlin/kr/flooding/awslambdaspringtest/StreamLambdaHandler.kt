package kr.flooding.awslambdaspringtest

import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler


class StreamLambdaHandler: RequestHandler<AwsProxyRequest, AwsProxyResponse> {
    override fun handleRequest(input: AwsProxyRequest, context: Context): AwsProxyResponse {
        return handler!!.proxy(input, context)
    }

    companion object {
        private var handler: SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>? = null

        init {
            try {
                handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(HealthController::class.java)
            } catch (ex: ContainerInitializationException) {
                throw RuntimeException("Unable to load spring boot application", ex)
            }
        }
    }
}