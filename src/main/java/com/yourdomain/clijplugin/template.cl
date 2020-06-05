// todo: Enter your OpenCL code here, rename the .cl file or generate an own .cl file.
//
// Use the method place holders READ_IMAGE_2D and READ_IMAGE_3D to read from an input image.
// Use the method place holders WRITE_IMAGE_2D and WRITE_IMAGE_3D to write to an ouput image.
// Mark your images as input images using the type place holders DTYPE_IMAGE_IN_2D and DTYPE_IMAGE_IN_3D.
// Mark your images as output images using the type place holders DTYPE_IMAGE_OUT_2D and DTYPE_IMAGE_OUT_3D.
// Pixel types of input and output images are specified with DTYPE_IN and DTYPE_OUT.
// To read the image size for within an OpenCL method, use the method place holders GET_IMAGE_IN_WIDTH,
// GET_IMAGE_IN_HEIGHT and GET_IMAGE_IN_DEPTH.
//
__constant sampler_t sampler = CLK_NORMALIZED_COORDS_FALSE | CLK_ADDRESS_CLAMP_TO_EDGE | CLK_FILTER_NEAREST;

__kernel void add_scalar(
    IMAGE_src_TYPE  src,
    IMAGE_dst_TYPE  dst,
    float scalar
)
{
  const int x = get_global_id(0);
  const int y = get_global_id(1);
  const int z = get_global_id(2);
  const POS_src_TYPE source_position = POS_src_INSTANCE(x,y,z,0);

  const float value = READ_IMAGE(src, sampler, source_position).x + scalar;

  const POS_dst_TYPE destination_position = POS_dst_INSTANCE(x,y,z,0);

  WRITE_IMAGE (dst, destination_position, CONVERT_dst_PIXEL_TYPE(value));
}
