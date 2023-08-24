package com.ivan;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Args {

    @Parameter(names = "-s", description = "second")
    public Integer seconds = 0;

    @Parameter(names = "-m", description = "second")
    public int minutes = 0;

    @Parameter(names = "-h", description = "second")
    public int hours = 0;
}
