def call(String folder_path, String s3_bucket_name, String aws_region) {
  def bucket = s3_bucket_name
  def folder = folder_path
  def region = aws_region

  def aws_cp = "aws s3 cp ${folder_path} s3://${bucket}/ --region ${region} --recursive".execute()
  def cp_buffer = new StringBuffer()
  aws_cp.consumeProcessErrorStream(cp_buffer)
  println(aws_cp.text)
  println(cp_buffer.toString())
  // long execution
  // aws_cp.waitForOrKill(5000)

  // check
  def aws_s3_out = "aws s3 ls s3://${bucket}/${folder_path}/ --region ${region}".execute()
  def ls_buffer = new StringBuffer()
  aws_ls.consumeProcessErrorStream(ls_buffer)
  println(aws_s3_out.text)
  println(ls_buffer.toString())
  // long execution
  // aws_s3_out.waitForOrKill(5000)

  return aws_s3_out
}