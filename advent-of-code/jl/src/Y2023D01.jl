# src/Y2023D01.jl
# Simon Hulse
# simonhulse@protonmail.com
# Last Edited: Mon 09 Sep 2024 11:44:22 PM EDT

module Y2023D01

using Printf

export p₁, p₂

function process_number_words(line::AbstractString)::AbstractString
    # First deal with overlapping cases
    line = replace(line,
        "twone" => "21",
        "oneight" => "18",
        "threeight" => "38",
        "fiveight" => "58",
        "sevenine" => "79",
        "eightwo" => "82",
        "eighthree" => "83")
    # Now deal with isolated numbers
    line = replace(line,
        "one" => "1",
        "two" => "2",
        "three" => "3",
        "four" => "4",
        "five" => "5",
        "six" => "6",
        "seven" => "7",
        "eight" => "8",
        "nine" => "9")
    line
end

firstlast(s::AbstractString) = s[1] * s[lastindex(s)]

function run(input::AbstractString, process_num_words::Bool)::Integer
    func = process_num_words ? process_number_words : identity
    [
        parse(Int, firstlast(filter(isdigit, String(func(line)))))
        for line in split(input, "\n", keepempty=false)
    ] |> sum
end

p₁(input) = run(input, false)
p₂(input) = run(input, true)

end
