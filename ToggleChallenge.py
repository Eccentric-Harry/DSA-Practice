def find_possible_digits(reference_digits, observed_digit):
    possible_digits = []
    for num, ref in reference_digits.items():
        mismatch_count = sum(1 for x, y in zip(observed_digit, ref) if x != y)
        if mismatch_count <= 1:
            possible_digits.append(num)
    return possible_digits

def main():
    standard_display = [input().strip() for _ in range(3)]
    faulty_display = [input().strip() for _ in range(3)]
    
    reference_digits = {}
    for digit in range(10):
        reference_digits[digit] = ''.join(
            standard_display[row][digit * 3:(digit + 1) * 3] for row in range(3)
        )
    
    identified_digits = []
    for segment in range(len(faulty_display[0]) // 3):
        current_digit_segment = ''.join(
            faulty_display[row][segment * 3:(segment + 1) * 3] for row in range(3)
        )
        possible_digits = find_possible_digits(reference_digits, current_digit_segment)
        if not possible_digits:
            print("Invalid", end='')
            return
        identified_digits.append(possible_digits)
    
    from itertools import product
    total_sum = 0
    for combination in product(*identified_digits):
        total_sum += int(''.join(map(str, combination)))
    
    print(total_sum, end='')

main()