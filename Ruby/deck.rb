class Card
	RANKS = ['A',2,3,4,5,6,7,8,9,10,'J','Q','K']
	SUITS = ['Clubs','Diamonds','Heart','Spade']

	attr_reader	:rank, :suit

	def initialize(rank, suit)
		@rank = RANKS[rank % 13]
		@suit = SUITS[suit % 4]
	end	

	def to_s
		"#{@rank} of #{@suit}"
	end
end

class Deck
	attr_reader :cards

	def initialize
		@cards = []
		0.upto(3) do |suits|
			0.upto(12) do |ranks|
				@cards << Card.new(ranks,suits)
			end
		end
	end

	def shuffle_cards
		@cards.shuffle!
	end

	def peek_random
		#draw and replace card
		@cards[rand(@cards.length-1)]
	end

	def peek_top
		@cards[-1]
	end

	def peek_bottom
		@cards[0]
	end

	def draw_card
		index = rand(@cards.length-1)
		tempCard = @cards[index]
		@cards.delete_at(index)
		return tempCard
	end

	def count
		@cards.length
	end

end

#test code
mydeck = Deck.new
puts "deck created"
#puts mydeck.cards.to_s

puts "deck shuffled"
mydeck.shuffle_cards
#puts mydeck.cards.to_s

puts ""
puts "peek at a random card"
mycard = mydeck.peek_random
puts mycard.to_s

puts ""
puts "draw card, no replacement"
puts mydeck.draw_card.to_s
puts "card deck now has #{mydeck.count} cards"

puts ""
puts "draw card, no replacement 2"
puts mydeck.draw_card.to_s
puts "card deck now has #{mydeck.count} cards"

puts ""
puts "peek at top"
puts mydeck.peek_top.to_s

puts ""
puts "peek at bottom"
puts mydeck.peek_bottom.to_s

