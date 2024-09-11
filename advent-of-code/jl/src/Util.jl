# src/Util.jl
# Simon Hulse
# simonhulse@protonmail.com
# Last Edited: Tue 10 Sep 2024 12:30:35 AM EDT

module Util

using Printf, TOML

export load_input, load_testcase

function load_testcase(year::Integer, day::Integer, part::Integer)::Tuple{AbstractString, Integer}
    filename = @sprintf("../../inputs/%d-%02d/part%d-example.toml", year, day, part)
    contents = open(filename) do fh
        read(fh, String)
    end
    toml = TOML.parse(contents)
    input = get(toml, "input", "")
    output = get(toml, "output", 0)
    return (input, output)
end

function load_input(year::Integer, day::Integer)::AbstractString
    filename = @sprintf("../inputs/%d-%02d/main.txt", year, day)
    input = open(filename) do fh
        read(fh, String)
    end
    input
end

end
