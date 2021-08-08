def call(String folder_path, String s3_bucket_name, String aws_region) {
  def bucket = s3_bucket_name
  def folder = folder_path
  def region = aws_region

  def aws_cp = "aws s3 cp ${folder_path} s3://${bucket}/ --region ${region}".execute()
  println("here")
  println(region)
  println(bucket)
  println(folder)
  // long execution
  // aws_cp.waitForOrKill(5000)

  // check
  def aws_s3_out = "aws s3 ls s3://${bucket}/${folder_path}/ --region ${region} --recursive".execute()
  // long execution
  // aws_s3_out.waitForOrKill(5000)

  return aws_s3_out
}