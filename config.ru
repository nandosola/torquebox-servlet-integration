# encoding: utf-8
require 'java'
require 'rubygems'
require 'bundler/setup'
require 'yaml'
require 'uri'

ENV['RACK_ENV'] ||= 'development'

require ::File.join( ::File.dirname(__FILE__), 'app' )

use Rack::ShowExceptions
run TestCase::SinatraHelloWorldApp
