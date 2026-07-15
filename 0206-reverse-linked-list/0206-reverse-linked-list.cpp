/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void rev(ListNode*& t, ListNode*& p, ListNode*& f) {
        if(t == NULL) return;
        f = t->next;
        t->next = p;
        p = t;
        t = f;
        rev(t, p, f);
    }

    ListNode* reverseList(ListNode* head) {
        ListNode* temp = head;
        ListNode* prev = NULL;
        ListNode* front = NULL;
        rev(temp, prev, front);
        return prev;
    }
};