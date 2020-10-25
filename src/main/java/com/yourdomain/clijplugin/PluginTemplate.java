package com.yourdomain.clijplugin;

import net.haesleinhuepf.clij.clearcl.ClearCLBuffer;
import net.haesleinhuepf.clij.macro.AbstractCLIJPlugin;
import net.haesleinhuepf.clij.macro.CLIJMacroPlugin;
import net.haesleinhuepf.clij.macro.CLIJOpenCLProcessor;
import net.haesleinhuepf.clij.macro.documentation.OffersDocumentation;
import net.haesleinhuepf.clij2.AbstractCLIJ2Plugin;
import net.haesleinhuepf.clij2.CLIJ2;
import net.haesleinhuepf.clij2.utilities.HasAuthor;
import net.haesleinhuepf.clij2.utilities.HasClassifiedInputOutput;
import net.haesleinhuepf.clij2.utilities.HasLicense;
import net.haesleinhuepf.clij2.utilities.IsCategorized;
import org.scijava.plugin.Plugin;

import java.util.HashMap;

/**
 * The PluginTemplate serves as starting point for making your own plugin.
 *
 * The name of the class and the name of your plugin method call must be as similar as shown here.
 * Assuming the class is called "PluginTemplate", the method name must be "CLIJ2_pluginTemplate". Otherwise, it may not
 * be found be the macro interpreter.
 *
 * Enter the correct name of your method here: -------------
 *                                                         |
 *                                                         |
 * Author: @haesleinhuepf                                  |
 *         June 2020                                       V
 */
@Plugin(type = CLIJMacroPlugin.class, name = "CLIJ2_pluginTemplate")
public class PluginTemplate extends AbstractCLIJ2Plugin implements CLIJMacroPlugin, CLIJOpenCLProcessor, OffersDocumentation, HasAuthor, HasLicense, HasClassifiedInputOutput, IsCategorized {

    @Override
    public boolean executeCL() {
        // -------------------------------------------------------------------------------------------------------------
        // todo: Build in your own code here. The variable args contains all parameters handed over in the order as
        //      entered in ImageJ macro or in the dialog. Images have type ClearCLBuffer, numbers come as Double.
        //      Use the methods asFloat(args[n]), asInteger(args[n]), asBoolean(args[n]) to convert them properly.

        boolean result = addScalar(getCLIJ2(), (ClearCLBuffer)( args[0]), (ClearCLBuffer)(args[1]), asFloat(args[2]));

        // -------------------------------------------------------------------------------------------------------------
        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // todo: enter your corde here. The argument order may be changed. However, it is recommended to use the same order
    //       as defined in the getParameterHelpText() method to prevent confusion.
    private boolean addScalar(CLIJ2 clij2, ClearCLBuffer src, ClearCLBuffer dst, Float scalar) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("src", src);
        parameters.put("scalar", scalar);
        parameters.put("dst", dst);

        // todo: The location of the .cl file must be relative to the class specified below:
        clij2.execute(PluginTemplate.class, "template.cl", "add_scalar", src.getDimensions(), src.getDimensions(), parameters);
        return true;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // todo: enter the list of parameters you need in order to make your algorithm run properly. Use the words
    //       Image, Number, String, Boolean to specify the right types.
    //       Name your output images with a name containing "destination" to make CLIJ generate them automatically and
    //       not prompt the user for it.
    @Override
    public String getParameterHelpText() {
        return "Image source, ByRef Image destination, Number scalar";
    }


    // -----------------------------------------------------------------------------------------------------------------
    // todo: enter the documentation for your plugin here:
    @Override
    public String getDescription() {
        return "Detailed description of your plugin.\n" +
                "What happens to the image?" +
                "What do the parameters mean?";
    }

    // -----------------------------------------------------------------------------------------------------------------
    // todo: enter the image dimensionality for which your algorithm might be applied:
    @Override
    public String getAvailableForDimensions() {
        return "2D, 3D";
    }

    @Override
    public String getCategories() {
        return "Filter";
    }

    @Override
    public String getInputType() {
        return "Image";
    }

    @Override
    public String getOutputType() {
        return "Image";
    }


    @Override
    public String getAuthorName() {
        return "Your name";
    }
    
    @Override
    public String getLicense() {
        return "Choose a license.";
    }
}