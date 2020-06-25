// todo: Enter your OpenCL code here, rename the .cl file or generate an own .cl file.
//
// Use the method place holders READ_IMAGE to read from an input image.
// Use the method place holders WRITE_IMAGE to write to an ouput image.
// Mark your images as input images using the type place holders IMAGE_src_TYPE where 'src' stands for your variable name.
// To read the image size for within an OpenCL method, use the method place holders GET_IMAGE_WIDTH,
// GET_IMAGE_HEIGHT and GET_IMAGE_DEPTH.
// You find more details on these convenience place holders online: https://github.com/clEsperanto/clij-opencl-kernels
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
