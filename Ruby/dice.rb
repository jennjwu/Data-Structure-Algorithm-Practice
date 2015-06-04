class Dice
	def get_side
		rand(6)+1 
	end

	def roll
		puts "rolling...got: #{get_side}"
	end
end

die1 = Dice.new
puts "Die 1 Rolls"
5.times {die1.roll}

die2 = Dice.new
puts "Die 2 Rolls"
5.times {die2.roll}