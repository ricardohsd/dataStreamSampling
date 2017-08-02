# Stream data

This project accepts a stream of data and prints random characters contained in the original stream.

Instead of consuming the entire stream, it will take the given capacity (e.g: 5) and consume at maximum 101 times it.
This would mean that for streams with:
- 5 characters: it will return all characters.
- less than 506: it would return a random sample contained in the stream.
- more than 506: it would return a random sample contained in the first 506 characters of the stream.

This approach isn't perfect, but it should perform well with huge streams.

## How to run it

First you need to package it:
```
$ mvn package
```

Then stream data into it:
```
$ cat input.txt | java -jar target/dataStreaming-1.0-SNAPSHOT.jar 5
  Random Sample: CIYUQ
```

## Tests

To run tests execute:

```
$ mvn test
```