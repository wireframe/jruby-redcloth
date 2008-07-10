require 'java'

class RedClothDelegator < com.codecrate.textile.TextileEngine
  def initialize(*args)
    @redcloth = RedCloth.new(*args)
  end
  def toHtml
    @redcloth.to_html   
  end
end
