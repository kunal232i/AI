% Define the possible moods and exercises
mood(happy).
mood(sad).
mood(stressed).
mood(tired).
exercise(yoga).
exercise(running).
exercise(weightlifting).
exercise(swimming).

% Define the rules for recommending exercises based on mood
exercise_for_mood(happy, yoga).
exercise_for_mood(sad, running).
exercise_for_mood(stressed, weightlifting).
exercise_for_mood(tired, swimming).

% Define the main query that asks the user for their mood and provides a recommendation
main :-
    write('Enter your current mood: '),
    read(Mood),
    exercise_for_mood(Mood, Exercise),
    write('Based on your mood, we recommend trying '),
    write(Exercise),
    write('.').
