# What to test (draft)
## Positive check
1. As a statement without subject with body;
2. As an expression with subject with body;
3. As a statement non-exhaustive;
4. As an expression exhaustive;
5. As an expression variable assignment;
6. As an expression method argument;
7. Cases returning same types;
8. Cases returning different types;
9. Case with block single-line;
10. Case with block multiple-line;
11. Case mixed with/without block;
12. Block throwing exception;
13. Nested where block;
14. Multiple matches - first match triggered;
15. Single match;
16. No match - else fallback;
17. Expression with exhaustive matches by enum/sealed class/boolean;
18. Else written in first/last/in the middle line;
19. Multiple condition (coma separated);
20. Use boolean literals;
21. Use boolean expressions;
22. Check range in/!in;
23. Mix method/range/equality/guard condition;
24. Capture the subject in a variable;
25. Guard condition for subject when with match;
26. Guard condition for subject when without match;
27. Guard condition for subject when partial;
28. Guard condition for subject when extensive;
29. Guard condition for expression when with match and else;
30. Guard condition for expression when with matching else;
31. Guard condition with if;
32. Guard condition with else if;
33. Match by variable;
34. Match by literal;
35. Match by null;

## Negative ('red') checks
1. when expression non-exhaustive without else;
2. else is not the last case;
3. when expression with empty block;
4. without subject condition type mismatch;
5. with subject condition incompatible type;