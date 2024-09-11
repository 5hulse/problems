# src/AoC.jl
# Simon Hulse
# simonhulse@protonmail.com
# Last Edited: Mon 09 Sep 2024 11:53:49 PM EDT

module AoC

export Util
export Y2023D01

using Printf

include("Util.jl")
include("Y2023D01.jl")

function main()
    y2023_d01_input = Util.load_input(2023, 1)
    @printf("2023, Day 01... Part 1: %d, Part 2: %d", Y2023D01.p₁(y2023_d01_input), Y2023D01.p₂(y2023_d01_input))
end

end
