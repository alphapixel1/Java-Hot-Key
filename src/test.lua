function tablelength(T)
  local count = 0
  for _ in pairs(T) do count = count + 1 end
  return count
end


function run(keys)
    print(keys)
    print("length " .. tablelength(keys))
    print(keys[0])
    print(keys[1])
    print(keys[2])
    print(keys[3])
    print(keys[4])
    print(keys[5])
    print(keys[6])
end