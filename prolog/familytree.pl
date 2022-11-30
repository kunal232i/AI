/*
predicates
	parent(symbol,symbol).
	female(symbol).
	male(symbol).
	mother(symbol,symbol).
	father(symbol,symbol).
	haschild(symbol).
	sister(symbol,symbol).
	brother(symbol,symbol).

clauses
*/
	male(baba).
	male(bhagwan).
	male(kunal).

	female(aai).
	female(kavita).
	female(vishakha).

	parent(kavita,kunal).
	parent(bhagwan,kunal).
	parent(kavita,vishakha).
	parent(bhagwan,vishakha).
	parent(baba,bhagwan).
	parent(aai,bhagwan).


	mother(X,Y):- parent(X,Y),female(X).
	father(X,Y):- parent(X,Y),male(X).
	haschild(X):- parent(X,_).
	sister(X,Y):- parent(Z,X),parent(Z,Y),female(X),X\==Y.
	brother(X,Y):- parent(Z,X),parent(Z,Y),male(X),X\==Y.