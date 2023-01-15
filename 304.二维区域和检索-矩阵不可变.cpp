/*
 * @lc app=leetcode.cn id=304 lang=cpp
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */
#include<string>
#include<algorithm>
#include<vector>
using namespace std;
// @lc code=start
class NumMatrix {
private:
    vector<vector<int>> preSum;
public:
    NumMatrix(vector<vector<int>>& matrix) {
        int row = matrix.size();
        int col = matrix[0].size();
        preSum.resize(row + 1);
        for (int i = 0; i < preSum.size(); i++)
            preSum[i] = vector<int>(col + 1, 0);
        for (int i = 1; i < row + 1; i++)
            for (int j = 1; j < col + 1; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

