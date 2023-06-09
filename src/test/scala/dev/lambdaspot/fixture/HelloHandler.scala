package dev.lambdaspot.fixture

import com.amazonaws.services.lambda.runtime.Context
import com.github.plokhotnyuk.jsoniter_scala.core.JsonValueCodec
import com.github.plokhotnyuk.jsoniter_scala.macros.JsonCodecMaker
import dev.lambdaspot.aws.lambda.core.{ApiGatewayLambda, AwsLambdaEntryPoint}
import dev.lambdaspot.aws.lambda.events.ApiGatewayProxiedRequest

import scala.util.{Success, Try}

object HelloHandler extends AwsLambdaEntryPoint:
  override lazy val entryPoint: HelloHandler = new HelloHandler(greeter)
  private lazy val greeter                   = new GreetingsService

class HelloHandler(greeter: GreetingsService) extends ApiGatewayLambda[GreetingsDto]:
  override def run(input: ApiGatewayProxiedRequest, context: Context): Try[GreetingsDto] =
    greeter.process(input.pathParameters)
