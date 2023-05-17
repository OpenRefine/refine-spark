Spark extension for OpenRefine
==============================

This extension makes it possible to use [Apache Spark](https://spark.apache.org/) as execution backend for OpenRefine.

It is an experimental feature which is designed to work with OpenRefine 4.0, currently in development.

## Building

Run `mvn package`.
This will build, run tests and create a file in `target/spark-extension-0.1-SNAPSHOT.zip`.

## Usage

Install the extension in OpenRefine.
Then, you can run OpenRefine with the Spark runner: `./refine -r org.openrefine.runners.spark.SparkRunner`. This will spin up a local Spark cluster and use it to execute all operations run within this OpenRefine instance.

## Known limitations

Using this runner for interactive data cleaning will generally be less efficient than the default runner. We expect this integration to become more interesting when running OpenRefine workflows from the command line, which is currently only possible via third-party tools and not officially supported by OpenRefine.

Some interactive features (such as progress reporting) are not available with this runner.

## Configuration parameters

The following configuration parameters are supported:
* `refine.runner.sparkMasterURI`: the URI of the existing Spark instance to connect to. If not provided, a local Spark instance will be used;
* `refine.runner.defaultParallelism`: the default parallelism of the local Spark instance that is spun up (if any).

Those options can be set up in `refine.ini` or on the command line (`-x refine.runner.sparkMasterURI=mysparkhost.com`).
