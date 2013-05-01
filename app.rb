# encoding: utf-8
require 'sinatra/base'

module TestCase
  class SinatraHelloWorldApp < Sinatra::Base
    set :logging, true

    get '/', provides: 'text/plain' do
      'Hello from the depths of my Sinatra racked app!'
    end

  end
end

