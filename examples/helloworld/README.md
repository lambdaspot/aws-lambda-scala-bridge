## Example AWS Lambda Application

This example illustrates creating a simple AWS Lambda function using a detailed implementation method. It is beneficial
for larger projects that involve multiple services. By designing the Lambda controller as a class with
constructor-injected dependencies, the application becomes more maintainable and extensible, making it easier to meet
complex project demands.

## Building deployable artifact

To build a deployment package using [Scala-CLI](https://scala-cli.virtuslab.org/), run the following command:

```bash
scala-cli --power package HelloHandler.scala --assembly --preamble=false
```

Run the function locally
using [AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html):

```bash
sam local start-api
```

Visit http://localhost:3000/hello/Jerry to see the result.