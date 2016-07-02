# Console
A generic console library for ease of creating a console window during runtime.

Visit the [releases page](https://github.com/qwertysam/Console/releases) for the jar and source code downloads.

## Usage
At the beginning of your program, use the method

    Console.initialize();

This will set up the window and streams. From then on, all print calls from `System.out` or `System.err` will be put through the console streams.

#### Visibility
To set the visibility of the console, use the method `Console.setVisibility(true/false)` or alternatively use `Console.hide()` or `Console.show()`

#### Manipulating Streams

This library also acts as a primtive manager for all your print streams through the use of the `MultiOutputStream` class. This class, as its name suggests, contains multiple `OutputSteam`s. The `MultiOutputSteam`s for the console can be accessed with `Console.getOutputStream()` and `Console.getErrorStream()`

If you'd like to add your own print steam to the console, you can do so by adding your own streams to the existing ones kept in the `Console` class.

##### Example (Adding a file log)
    // Creates the file log as an output stream
    FileOutputStream fil = null;
    try {
      fil = new FileOutputStream("log.txt");
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    // If the stream was created, add it to the console streams
    if (fil != null) {
      Console.getOutputStream().addStream(fil);
      Console.getErrorStream().addStream(fil);
    }

Using this example, all print calls from `System.out` or `System.err` will now also print to the log file `log.txt` 
