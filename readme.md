## CLIJ2 plugin template

This repository contains a simple CLIJ2 plugin. Clone it to make your own [CLIJ2](https://clij.github.io/clij2-docs) 
plugin and run your [OpenCL](https://www.khronos.org/opencl/) code from ImageJ macro.

Just open [pom.xml](pom.xml) and enter your name, domain, the name of your plugin etc. 
Afterwards, navigate to [PluginTemplate.java](src/main/java/com/yourdomain/clijplugin/PluginTemplate.java) 
to inspect the API of a basic CLIJ plugin. 
Furthermore, you find example OpenCL code in ClearCLs dialect in [template.cl](src/main/java/com/yourdomain/clijplugin/template.cl).

In order to deploy your plugin to your Fiji installation, enter the correct path of your Fiji to the pom file:

```xml
<scijava.app.directory>C:/programs/fiji-win64/Fiji.app/</scijava.app.directory>
```

Afterwards, run

```
mvn install
```

Restart Fiji and check using this macro if your plugin was installed successfully:

```java
run("CLIJ2 Macro Extensions", "cl_device=");
Ext.CLIJ2_help("pluginTemplate");
```

The ImageJ log window should then output something like:

```java
Found 1 method(s) containing the pattern "pluginTemplate":
Ext.CLIJ2_pluginTemplate(Image source, Image destination, Number scalar);
```

Next steps would be changing Java and OpenCL code to your needs. Let me know how it goes! Contact me on the 
image.sc forum by tagging @haesleinhuepf, leave a github issue or drop a mail to rhaase@mpi-cbg.de

Happy coding!

Cheers,
Robert
