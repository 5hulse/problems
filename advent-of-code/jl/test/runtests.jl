# test/runtests.jl
# Simon Hulse
# simonhulse@protonmail.com
# Last Edited: Mon 09 Sep 2024 11:40:28 PM EDT

using AoC
using Test


y2023_d01_p1_input, y2023_d01_p1_output = AoC.Util.load_testcase(2023, 1, 1)
y2023_d01_p2_input, y2023_d01_p2_output = AoC.Util.load_testcase(2023, 1, 2)
@test AoC.Y2023D01.p₁(y2023_d01_p1_input) == y2023_d01_p1_output
@test AoC.Y2023D01.p₂(y2023_d01_p2_input) == y2023_d01_p2_output
