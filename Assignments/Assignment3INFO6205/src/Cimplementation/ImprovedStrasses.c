#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct matrix {
    int row;
    int col;
    int **mat;
} matrix;

matrix *create_matrix(int row, int col);

matrix *strassens_multiply(matrix *m1, matrix *m2, int n);

matrix *add_matrix(matrix *m1, matrix *m2);

matrix *sub_matrix(matrix *m1, matrix *m2);

void delete_matrix(matrix **m);

int main() {
    int n;
    printf("Enter size of matrix:\n");
    scanf("%d", &n);

    matrix *A = create_matrix(n, n);
    matrix *B = create_matrix(n, n);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            A->mat[i][j] = rand()%10+1;
            B->mat[i][j] = rand()%10+1;
        }
    }

    clock_t t;
    t = clock();

    matrix *C = strassens_multiply(A, B, n);

    t = clock() - t;
    double time_taken = ((double)t)/CLOCKS_PER_SEC;

    printf("%f\n", time_taken);

//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) {
//            printf("%d ",C->mat[i][j]);
//        }
//        printf("\n");
//    }

    delete_matrix(&A);
    delete_matrix(&B);
    delete_matrix(&C);
    return 0;
}

matrix *strassens_multiply(matrix *m1, matrix *m2, int n) {
    matrix *ans = create_matrix(n, n);
    if(n <= 256) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans->mat[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    ans->mat[i][j] += m1->mat[i][k] * m2->mat[k][j];
                }
            }
        }

        return ans;
    }

    matrix *a1 = create_matrix(n / 2, n / 2);
    matrix *a2 = create_matrix(n / 2, n / 2);
    matrix *b1 = create_matrix(n / 2, n / 2);
    matrix *b2 = create_matrix(n / 2, n / 2);
    matrix *c1 = create_matrix(n / 2, n / 2);
    matrix *c2 = create_matrix(n / 2, n / 2);
    matrix *d1 = create_matrix(n / 2, n / 2);
    matrix *d2 = create_matrix(n / 2, n / 2);

    for(int i=0; i<n/2; i++) {
        for(int j=0; j<n/2; j++) {
            a1->mat[i][j] = m1->mat[i][j];
            a2->mat[i][j] = m2->mat[i][j];
            b1->mat[i][j] = m1->mat[i][j+(n/2)];
            b2->mat[i][j] = m2->mat[i][j+(n/2)];
            c1->mat[i][j] = m1->mat[i+(n/2)][j];
            c2->mat[i][j] = m2->mat[i+(n/2)][j];
            d1->mat[i][j] = m1->mat[i+(n/2)][j+(n/2)];
            d2->mat[i][j] = m2->mat[i+(n/2)][j+(n/2)];
        }
    }

    matrix *add1 = add_matrix(a1, b1);
    matrix *add2 = add_matrix(c1, d1);
    matrix *add3 = add_matrix(a1, d1);
    matrix *add4 = add_matrix(a2, d2);
    matrix *add5 = add_matrix(c2, d2);
    matrix *add6 = add_matrix(a2, b2);

    matrix *sub1 = sub_matrix(b2, d2);
    matrix *sub2 = sub_matrix(c2, a2);
    matrix *sub3 = sub_matrix(b1, d1);
    matrix *sub4 = sub_matrix(a1, c1);

    matrix *p1 = strassens_multiply(a1, sub1, n / 2);
    matrix *p2 = strassens_multiply(add1, d2, n / 2);
    matrix *p3 = strassens_multiply(add2, a2, n / 2);
    matrix *p4 = strassens_multiply(d1, sub2, n / 2);
    matrix *p5 = strassens_multiply(add3, add4, n / 2);
    matrix *p6 = strassens_multiply(sub3, add5, n / 2);
    matrix *p7 = strassens_multiply(sub4, add6, n / 2);

    matrix *x1 = add_matrix(sub_matrix(add_matrix(p5, p4), p2), p6);
    matrix *x2 = add_matrix(p1, p2);
    matrix *x3 = add_matrix(p3, p4);
    matrix *x4 = sub_matrix(sub_matrix(add_matrix(p1, p5), p3), p7);

    for(int i=0; i<n/2; i++) {
        for(int j=0; j<n/2; j++) {
            ans->mat[i][j] = x1->mat[i][j];
            ans->mat[i][j+n/2] = x2->mat[i][j];
            ans->mat[i+n/2][j] = x3->mat[i][j];
            ans->mat[i+n/2][j+n/2] = x4->mat[i][j];
        }
    }

    delete_matrix(&a1);
    delete_matrix(&a2);
    delete_matrix(&b1);
    delete_matrix(&b2);
    delete_matrix(&c1);
    delete_matrix(&c2);
    delete_matrix(&d1);
    delete_matrix(&d2);

    delete_matrix(&add1);
    delete_matrix(&add2);
    delete_matrix(&add3);
    delete_matrix(&add4);
    delete_matrix(&add5);
    delete_matrix(&add6);
    delete_matrix(&sub1);
    delete_matrix(&sub2);
    delete_matrix(&sub3);
    delete_matrix(&sub4);

    delete_matrix(&p1);
    delete_matrix(&p2);
    delete_matrix(&p3);
    delete_matrix(&p4);
    delete_matrix(&p5);
    delete_matrix(&p6);
    delete_matrix(&p7);

    return ans;
}

void delete_matrix(matrix **m) {
    if(m == NULL) {
        return;
    }

    matrix *temp = *m;
    if(temp == NULL) {
        return;
    }

    for(int i = 0; i < temp->row; i++) {
        free(temp->mat[i]);
    }

    free(temp->mat);
    free(temp);

    *m = NULL;
}

matrix *add_matrix(matrix *m1, matrix *m2) {
    int len = m1->row;
    matrix *add = create_matrix(len, len);
    if(add == NULL) {
        return NULL;
    }
    for(int i=0; i<len; i++) {
        for(int j=0; j<len; j++) {
            add->mat[i][j] = m1->mat[i][j] + m2->mat[i][j];
        }
    }

    return add;
}

matrix *sub_matrix(matrix *m1, matrix *m2) {
    int len = m1->row;
    matrix *sub = create_matrix(len, len);
    if(sub == NULL) {
        return NULL;
    }
    for(int i=0; i<len; i++) {
        for(int j=0; j<len; j++) {
            sub->mat[i][j] = m1->mat[i][j] - m2->mat[i][j];
        }
    }

    return sub;
}

matrix *create_matrix(int row, int col) {
    if (row <= 0 || col <= 0) {
        return NULL;
    }

    matrix *temp = (matrix *) malloc(sizeof (matrix));
    if(temp == NULL) {
        printf("Out of memory\n");
        return NULL;
    }

    temp->row = row;
    temp->col = col;

    temp->mat = (int **) malloc(row * sizeof (int *));

    if(temp == NULL) {
        printf("Out of memory\n");
        free(temp);
        return NULL;
    }

    for (int i = 0; i < row; i++) {
        temp->mat[i] = (int *) malloc(col * sizeof (int));
        if(temp->mat[i] == NULL) {
            printf("Out of memory\n");
            for(int j = 0; j < i; j++) {
                free(temp->mat[j]);
            }
            free(temp->mat);
            free(temp);
        }
    }

    return temp;
}
