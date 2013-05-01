TorqueBox.configure do
  web do |web|
    web.context '/'
  end
  ruby do
    version '1.9'
  end
  environment do
    TMPDIR '/tmp/torquebox'
  end
end
